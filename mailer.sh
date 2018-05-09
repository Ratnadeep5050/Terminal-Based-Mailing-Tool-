#!/bin/bash

java -cp mail.jar: Main

echo 'Your email ID ... '
read senderEmail

echo 'You password ... '
stty -echo
read senderPassword
stty echo

echo 'Receiver email ID ... '
read receiverEmail

echo 'Email subject ... '
read subject

echo 'Email text file path ... '
read filePath

java -cp mail.jar: Main "$senderEmail" "$senderPassword" "$receiverEmail" "$subject" "$filePath"
