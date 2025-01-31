#!/usr/bin/env node
import { program } from "commander";
import chalk from "chalk";
import { vend } from "./vending/vending-machine.js";

program
  .version("1.0.0")
  .description("Vending Machine App")
  .option("-n, --name <type>", "Add your name")
  .action((options) => {
    console.log(chalk.blue(`Hello, ${options.name}, please select an option`));
    vend();
  });

program.parse(process.argv);