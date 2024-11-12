#!/bin/bash

# Check if google-java-format JAR is already downloaded
if [ -f google-java-format.jar ]; then
  echo -e "\ngoogle-java-format JAR already downloaded."
else
  echo -e "\nDownloading google-java-format JAR..."
  curl -L -o google-java-format.jar https://github.com/google/google-java-format/releases/download/v1.25.0/google-java-format-1.25.0-all-deps.jar
  if [ $? -ne 0 ]; then
    echo "Error: Failed to download google-java-format JAR."
    exit 1
  fi
fi

# Format Java files
echo -e "\nFormatting Java files..."
find . -type f -name "*.java" | while read -r file; do
  echo "Formatting $file..."
  java -jar google-java-format.jar --replace "$file"
  if [ $? -ne 0 ]; then
    echo "Error: Failed to format $file."
    exit 1
  fi
done

echo -e "\nCode formatting completed successfully."