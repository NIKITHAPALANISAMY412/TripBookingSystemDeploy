variable "aws_region" {
  type    = string
  default = "ap-south-1"
}

variable "instance_type" {
  type    = string
  default = "t3.micro"
}

variable "docker_username" {
  type        = string
  description = "Your Docker Hub username"
  default     = "nikithap2002"
}

variable "datasource_url" {
  type        = string
  description = "Database connection URL"
  default     = "jdbc:h2:mem:nikidb"
}

variable "datasource_username" {
  type        = string
  description = "Database username"
  default     = "sa"
}

variable "datasource_password" {
  type        = string
  description = "Database password"
  default     = ""
  sensitive   = true
}
