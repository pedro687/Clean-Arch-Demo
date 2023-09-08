resource "aws_dynamodb_table" "demo_table" {

  name           = "cleanArchTable"
  read_capacity  = 5
  write_capacity = 5
  hash_key       = "pk"
  range_key      = "sk"


  attribute {
    name = "pk"
    type = "S"
  }

  attribute {
    name = "sk"
    type = "S"
  }

  attribute {
    name = "email"
    type = "S"
  }

  attribute {
    name = "status"
    type = "S"
  }



  global_secondary_index {
    name               = "Gsi"
    hash_key           = "sk"
    range_key          = "pk"
    write_capacity     = 5
    read_capacity      = 5
    projection_type    = "ALL"
  }

  global_secondary_index {
    name               = "GsiStatus"
    hash_key           = "status"
    range_key          = "pk"
    write_capacity     = 5
    read_capacity      = 5
    projection_type    = "ALL"
  }

  global_secondary_index {
    name               = "GsiEmail"
    hash_key           = "email"
    range_key          = "pk"
    write_capacity     = 5
    read_capacity      = 5
    projection_type    = "ALL"
  }

  tags = {
    Name        = "Dynamo-DB-Table"
    Environment = "Dev"
  }
}