/**
 * Someone has written some really smelly code!
 * In the file below, we are reading the data from data.csv, and printing it in a human readable format
 * (IE each line in the csv printed like this: "email : thisemail@fake.com")
 * There are many bad practices here, and a few bugs.
 *
 * Your job is to modify code so that it works, and is up to your standards.
 * Feel free to run the program, run the unit tests and change anything you see fit.
 *
 * Good luck!
 */

import * as fs from 'fs';

// Main function
function main() {
    var path = "data.csv";
    // 1. Read data from file
    var Data_From_File: any = ReadFromFile(path);
    var aaray = Data_From_File.split("\n");
    displayData(aaray);
    // We want to use this data in our program
}

/////////////////////////// Helper method ///////////////////////////
function ReadFromFile(s: string): any {
    try {
        var data: any = "";
        var fileContent = fs.readFileSync(s, 'utf8');
        var lines = fileContent.split('\n');
        data += lines[0] + "\n";
        return data;
    } catch (e) {
        console.log("An error occurred.");
        return "";
    }
}

function Process_UserData(userData: any): any {
    var processedData: any = {};
    var data = userData[1];
    var headers = userData[0];

    var parts = headers.split(",");
    for (var i = 0; i < parts.length; i++) {
        var dataParts = data.split(",");
        processedData[parts[i]] = dataParts[i];
    }

    return processedData;
}

function displayData(userData: Array<any>) {
    var data: Object = Process_UserData(userData);

    // Display the data that we can use everywhere in our program
    for (var key in data) {
        console.log(key + " : " + data[key]);
    }
}

// Run the program
main();

export { main, ReadFromFile, Process_UserData, displayData };