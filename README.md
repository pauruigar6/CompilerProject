# Compiler Project (IFJe 23/24)

Author: Paula Ruiz Gardón.  
Login: xruig03. 

Repository Link: [Compiler Project](https://github.com/pauruigar6/WebDesign.git).

## Overview

This is a simple compiler implementation in Java that performs lexical, syntax, and expression evaluation analysis on a mathematical expression. The compiler supports basic arithmetic operations like addition, subtraction, multiplication, division, modulo, and exponentiation.

## Table of Contents

1. [Introduction](#introduction)
2. [Implementation Details](#implementation-details)
3. [Project Structure](#project-structure)
4. [Usage](#usage)
5. [Class Structure](#class-structure)
6. [Methods](#methods)
7. [Example](#example)

## Introduction

The **Compiler** class provides functionalities to analyze and evaluate mathematical expressions. It processes the input expression through lexical analysis, syntax analysis, and expression evaluation.

## Implementation Details

- **Language used**: Java.
- **Libraries**:
  - **java.util.Deque**: maintain two stacks (stack1 and stack2) for performing syntactic analysis and evaluating mathematical expressions.
  - **java.util.LinkedList**: serves as the implementation for your double-ended queues (Deque).
  - **java.util.Scanner**: allows you to use the Scanner class within the MainCompiler class without having to reference the full package path every time you use it.

## Project Structure

- **/src**: It contains the different Java modules that make up the project.
  - **Compiler.java**: Represents a simple compiler for mathematical expressions. It performs lexical analysis, syntax analysis, and expression evaluation.
  - **MainCompiler.java**: Contains the main method for the mathematical expression compiler.ción main.

## Usage

To use the **Compiler**, create an instance of the Compiler class, providing the mathematical expression as input. Then, call the **`displayResult()`** method to see the analyzed expression and the result of its evaluation.

```java
public class Main {
    public static void main(String[] args) {
        Compiler compiler = new Compiler("add(5, mul(3, sub(10, pow(6, 4))))");
        compiler.displayResult();
    }
}
```

## Class Structure

The class is structured as follows:

- **Compiler**: The main class that encapsulates the entire compiler functionality.
- Fields:
  - **input**: The input mathematical expression.
  - **stackString**: A string used to store tokens during lexical analysis.
  - **keywords**: A string containing supported mathematical operations.
  - **syntaxResult**: A string to store the result of syntax analysis.
  - **currentState**: An integer representing the current state during lexical analysis.
  - **stack1** and **stack2**: Deques used for syntax analysis and expression evaluation.

## Methods

- **`performLexicalAnalysis()`**
  This method performs lexical analysis on the input expression, identifying tokens and validating their structure.

- **`performSyntaxAnalysis()`**
  This method performs syntax analysis on the tokenized expression, generating a syntactically correct representation.

- **`evaluateExpression()`**
  This method evaluates the expression based on the syntax analysis result, considering the precedence of operators.

- **`keyToChar(String token)`**
  A utility method that converts a keyword token to its corresponding mathematical operator.

- **`displayResult()`**
  This method orchestrates the entire compilation process, displaying the input expression, syntax analysis result, and the evaluated result.

## Example

For the input expression: add(5, mul(3, sub(10, pow(6, 4))))

The output would be:

```css
Input: add(5, mul(3, sub(10, pow(6, 4))))
Output: 5+3*(10-6^4)
Result: 14.0
```
