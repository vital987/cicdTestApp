# Basic Spring Boot app for unit testing

## Introduction
#### The app basically gets two random numbers, computes 4 arithmatic operations [+, -, \*, /] and displays on the webpage. The app also displays hostname (or pod name in K8s) for my project use.

## Testing
#### The app testing is done by Junit-5 & Selenium. For the first 4 tests, Selenium gets the two random numbers from the webpage, calculates the result (separate test for every arithmetic operation) and matches with the result on webpage. 5th test checks for the availability of $HOSTNAME variable on the system.
<img src="https://imgur.com/WeTg5Oo.png">
