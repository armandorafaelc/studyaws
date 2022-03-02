provider "aws" {
  region      = "sa-east-1"
  access_key = "ASHUDSAUDHASUDHASD"
  secret_key = "AHUSDHAUDHAUSDHAUHDSA"
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true

  endpoints {
    dynamodb = "http://localhost:4566"
    sqs   = "http://localhost:4566"
    sns  = "http://localhost:4566"
  }
}

//--------------------------------------------- SQS
resource "aws_sqs_queue" "sqs-broadcast-deadletter" {
  name                      = "sqs-broadcast-deadletter"
  delay_seconds             = 90
  max_message_size          = 2048
  message_retention_seconds = 86400
  receive_wait_time_seconds = 10
}

resource "aws_sqs_queue" "sqs-broadcast" {
  name                      = "sqs-broadcast"
  delay_seconds             = 90
  max_message_size          = 2048
  message_retention_seconds = 86400
  receive_wait_time_seconds = 10
  redrive_policy = jsonencode({
    deadLetterTargetArn = aws_sqs_queue.sqs-broadcast-deadletter.arn
    maxReceiveCount     = 4
  })
}