terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "4.51.0"
    }
  }
}


provider "aws" {
  access_key = "teste"
  secret_key = "teste"
  skip_credentials_validation = true
  skip_requesting_account_id = true
  skip_metadata_api_check = true
  region = "us-east-1"
  endpoints {
    dynamodb = "http://localhost:4566"
  }
}