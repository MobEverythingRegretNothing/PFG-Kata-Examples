import { getInitialStock } from '../stock/stock.js';
import { printStock } from '../ui/ui-mapper.js';
import inquirer from 'inquirer';

/**********************************
 * Init starting state (Using array)
 *********************************/

var stock = getInitialStock();

export function vend() {
  console.log(`Available Options:\n${printStock(stock)}`);
  inquirer
    .prompt([
      {
        type: "input",
        name: "choice",
        message: "What do you want?",
      },
    ])
    .then((choice) => {
      if (stock.some((e) => e.name === choice.choice)) {
          const product = stock.find((e) => e.name === choice.choice);
          console.log(`Found it! That'll be $${product.price}`);
          return inquirer.prompt([{
            type: "input",
            name: "money",
            message: "Put some money in my slot-hole!"
          }])
          .then((result) => {
            if (Number(result.money) < product.price) {
              console.log('Not enough money! We are keeping the money you input as a penalty');
            } else {
              console.log('Vending for you...');
              if (Number(result.money) > product.price) {
                console.log(`Keep the change you filthy animal: [${Number(result.money) - product.price}]`)
              } else {
                console.log('No change for you, you no come back... 2 years!')
              }
            }
          })
    } else {
      console.log("There isn't anything called that in here :(")
    }
});
} 

export function getStock() {
  return stock;
}



// // Started with no loop for this one, could always loop in a future iteration
// r1.question(`Please input a choice?\n ${printStock(initialStock)}`, (choice) => {
//   r1.close()
//   const r2 = getInterface();
//     if (initialStock.some((e) => e.name === choice)) {
//       const stock = initialStock.find((e) => e.name === choice);
//       r2.question(`Please put in $${stock.price}...`, (money) => {
//           console.log(`Got the money $${money}`);
//           if (money < stock.price) {
//             console.log('Not enough money! We are keeping the money you input as a penalty');
//           } else {
//             console.log('Vending for you...');
//           }
//       })
//     } else {
//       console.log("No stock of that name");
//     }
//     r2.close();
//   });




