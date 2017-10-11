# Assumption
The message format is as follow.
-Type1: {"product":"apple","value":"£0.1"}
-Type2: {"product":"apple","amount":"20","value":"£0.1"}
-Type3: {"operation":"add","product":"apple","value":"£0.2"}

# To Build
1) mvn clean package
2) cd target
3) java -jar simplesale-jar-with-dependencies.jar


# Sample Input
The application assumes that the file "input.txt" exists.
Please create or copy the sample input.txt to target folder


# Sample Output
...
/******* summary per 10 sales *******/
Product: apple, Amount: 24, Value: 16.60
Product: banana, Amount: 31, Value: 3.10

/******* summary per 10 sales *******/
Product: apple, Amount: 55, Value: 33.45
Product: banana, Amount: 37, Value: 3.40
Product: orange, Amount: 32, Value: 1.60

/******* summary per 10 sales *******/
Product: apple, Amount: 118, Value: 40.35
Product: banana, Amount: 43, Value: 3.80
Product: orange, Amount: 59, Value: 9.50

/******* summary per 10 sales *******/
Product: apple, Amount: 150, Value: 84.98
Product: banana, Amount: 74, Value: 11.02
Product: orange, Amount: 59, Value: 9.50

/******* summary per 10 sales *******/
Product: apple, Amount: 182, Value: 142.48
Product: banana, Amount: 116, Value: 22.23
Product: orange, Amount: 120, Value: 15.60

/************** report **************/
Adjusted apple by 0.2 (add), 2 sale record(s) updated
Adjusted apple by 0.2 (add), 4 sale record(s) updated
Adjusted apple by 0.2 (add), 5 sale record(s) updated
Adjusted apple by 0.2 (add), 7 sale record(s) updated
Adjusted apple by 0.05 (add), 7 sale record(s) updated
Adjusted orange by 0.05 (subtract), 3 sale record(s) updated
Adjusted banana by 1.5 (multiply), 6 sale record(s) updated
Adjusted apple by 0.02 (add), 13 sale record(s) updated
Adjusted banana by 0.03 (add), 8 sale record(s) updated
Adjusted apple by 0.05 (subtract), 13 sale record(s) updated
Adjusted apple by 0.3 (add), 15 sale record(s) updated
Adjusted apple by 0.3 (add), 17 sale record(s) updated
Adjusted banana by 1.5 (multiply), 9 sale record(s) updated
Paused, stop accepting new messages
...
