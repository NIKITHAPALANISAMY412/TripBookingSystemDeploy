terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = var.aws_region
}

# ---------------- SECURITY GROUP ----------------
resource "aws_security_group" "trip_sg" {
  name        = "trip-sg"
  description = "Allow HTTP, App, and SSH access"

  ingress {
    description = "Frontend (Port 8085)"
    from_port   = 8085
    to_port     = 8085
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    description = "Backend (Port 9090)"
    from_port   = 9090
    to_port     = 9090
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    description = "SSH Access"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# ---------------- AMI ----------------
data "aws_ami" "amazon_linux2" {
  most_recent = true
  owners      = ["amazon"]

  filter {
    name   = "name"
    values = ["amzn2-ami-hvm-*-x86_64-gp2"]
  }
}

# ---------------- IAM ROLE + PROFILE ----------------
resource "aws_iam_role" "ec2_role" {
  name = "trip-ec2-role"

  assume_role_policy = jsonencode({
    Version = "2012-10-17",
    Statement = [{
      Action = "sts:AssumeRole"
      Effect = "Allow"
      Principal = {
        Service = "ec2.amazonaws.com"
      }
    }]
  })
}

resource "aws_iam_role_policy_attachment" "ssm_core" {
  role       = aws_iam_role.ec2_role.name
  policy_arn = "arn:aws:iam::aws:policy/AmazonSSMManagedInstanceCore"
}

resource "aws_iam_instance_profile" "ec2_profile" {
  name = "trip-ec2-profile"
  role = aws_iam_role.ec2_role.name
}

# ---------------- EC2 INSTANCE ----------------
resource "aws_instance" "trip_server" {
  ami                         = data.aws_ami.amazon_linux2.id
  instance_type               = var.instance_type
  vpc_security_group_ids      = [aws_security_group.trip_sg.id]
  iam_instance_profile        = aws_iam_instance_profile.ec2_profile.name
  associate_public_ip_address = true
  key_name                        = "myapp-pwd"

  
  user_data = <<-EOF
              #!/bin/bash
              exec > >(tee /var/log/user-data.log|logger -t user-data -s 2>/dev/console) 2>&1
              set -x
              
              yum update -y
              amazon-linux-extras install docker -y
              systemctl start docker
              systemctl enable docker
              usermod -a -G docker ec2-user

              sleep 10

              # Pull and run backend
              docker pull ${var.docker_username}/travel-booking-backend:latest
              docker rm -f travel-booking-backend || true
              docker run -d \
                --name travel-booking-backend \
                --restart unless-stopped \
                -p 9090:9090 \
                -e SPRING_DATASOURCE_URL="${var.datasource_url}" \
                -e SPRING_DATASOURCE_USERNAME="${var.datasource_username}" \
                -e SPRING_DATASOURCE_PASSWORD="${var.datasource_password}" \
                ${var.docker_username}/travel-booking-backend:latest

              # Pull and run frontend
              docker pull ${var.docker_username}/travel-booking-frontend:latest
              docker rm -f travel-booking-frontend || true
              docker run -d \
                --name travel-booking-frontend \
                --restart unless-stopped \
                -p 8085:80 \
                ${var.docker_username}/travel-booking-frontend:latest
              EOF

  tags = {
    Name = "trip-server"
  }
}

# ---------------- OUTPUTS ----------------
output "ec2_public_ip" {
  value       = aws_instance.trip_server.public_ip
  description = "Public IP of the Travel Booking EC2 instance"
}

output "backend_url" {
  value       = "http://${aws_instance.trip_server.public_ip}:9090"
  description = "Travel Booking Backend URL"
}

output "frontend_url" {
  value       = "http://${aws_instance.trip_server.public_ip}:8085"
  description = "Travel Booking Frontend URL"
}
