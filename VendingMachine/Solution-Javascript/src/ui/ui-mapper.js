import { createInterface } from 'readline';

export function getInterface() {
    // Allows getting user input
    return createInterface({
        input: process.stdin,
        output: process.stdout
    });
}

export function printStock(initialStock) {
    var str = "";

    initialStock.forEach(element => {
        str += (`\t* ${element.name}: ${element.price}\n`)
    });
    return str;
}