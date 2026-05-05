# • Level 1 - Builder Pattern

## 📌 Description

In this level, the **Builder design pattern** is implemented using a **Fluent Builder** approach combined with **Progressive Interfaces**.

The goal is to build a flexible system that allows constructing restaurant menus step by step, ensuring the correct order of operations at compile time.

---

## ⚙️ Functionality

The system allows:

- Building restaurant menus step by step
- Creating different types of menus:
  - Full menu (entrant + main + dessert/coffee + drink)
  - Half menu (main + drink)
  - Kids menu (main + dessert + drink)
- Configuring dishes with:
  - Vegan option
  - Gluten-free option
  - Supplement (only for the main course)
- Choosing between:
  - Dessert **or** coffee (mutually exclusive)
- Creating menus without a drink

---

## 🧠 Design

The following concepts have been applied:

### **Builder Pattern (Fluent)**
- Method chaining for a clean and readable construction process
- Avoids constructors with many parameters

### **Progressive Interface**
- Each step of the builder only exposes valid operations
- Prevents incorrect usage at compile time
- Examples:
  - Cannot add dessert before the main course
  - Cannot add both dessert and coffee

### **Separation of Responsibilities**
- `Menu` → final object (data only)
- `MenuBuilder` → construction logic
- Interfaces → control the flow

### **Use of Generics**
- Allows reuse of methods like `isVegan()` or `isGlutenFree()`
- Avoids code duplication
- Maintains fluent chaining

---

## 🔄 Build Flow

The process follows a strict order:

```
Start
  ↓
Entrant (optional)
  ↓
Main course (mandatory)
  ↓
Dessert or coffee (optional)
  ↓
Drink (optional)
  ↓
Build
```

---

## 🔑 Key Methods

### `goToMainCourse()`

Used after configuring the entrant.

- Ends the entrant configuration
- Moves to the main course step

Example:

```java
.withEntrant("Salad")
    .isVegan()
    .goToMainCourse()
```

---

### `finishMainOptions()`

Used after configuring the main course.

- Ends the main course configuration
- Moves to the next phase of the menu

Example:

```java
.withMainCourse("Steak")
    .withSupplement("Fries")
    .finishMainOptions()
```

---

## 🧪 Tests

Unit tests verify:

- Creation of different menu types
- Mutual exclusion between dessert and coffee
- Optional elements
- Correct application of properties (vegan, gluten-free, supplement)
- Proper construction of the final `Menu` object

---

## 💡 Usage Example

```java
Menu menu = new MenuBuilder()
    .withEntrant("Salad")
        .isVegan()
        .goToMainCourse()
    .withMainCourse("Steak")
        .withSupplement("Fries")
        .finishMainOptions()
    .withDessert("Cake")
    .withDrink("Water")
    .build();
```

---

## 🧠 Example Explanation

- An entrant is added and configured as vegan  
- The process moves to the main course  
- A supplement is added to the main course  
- The main course configuration is completed  
- Dessert and drink are added  
- The final menu is built  

---

# • Level 2 - Observer Pattern

## 📌 Description

In this level, the **Observer design pattern** is implemented to simulate a stock market notification system.

The goal is to build a system where a **StockAgent (Observable)** automatically notifies multiple **StockBrokerAgencies (Observers)** whenever the stock market value changes.

---

## ⚙️ Functionality

The system allows:

- Subscribing observers to the stock agent
- Unsubscribing observers dynamically
- Simulating stock market changes:
  - Market goes up
  - Market goes down
- Automatically notifying all observers when a change occurs
- Each observer receives and processes the notification message

---

## 🧠 Design

The following elements have been implemented:

### **Observer Interface**
- Defines the contract:
  - `update(String message)`
- Any observer must implement this method

---

### **Observable (StockAgent)**
- Maintains a list of observers
- Provides:
  - `addObserver()`
  - `removeObserver()`
  - `notifyObservers()`
- Triggers notifications when:
  - `stockMarketUp(value)`
  - `stockMarketDown(value)`

---

### **Concrete Observer (StockBrokerAgency)**
- Implements `Observer`
- Receives updates from `StockAgent`
- Stores the last received message
- Displays the message on screen

---

## 🔄 Flow

```text
Create StockAgent
Create Observers
Subscribe observers

Stock changes →
StockAgent creates message →
notifyObservers() →
Each observer receives update(message)
```

---

## 🔑 Key Concept

The `StockAgent` does not know how observers handle the message.

It only knows that:

> “All observers implement update(), so I can notify them.”

This keeps the system **loosely coupled** and easily extendable.

---

## 🧪 Tests

Unit tests verify:

- Subscription of multiple observers
- Correct notification when the stock goes up
- Correct notification when the stock goes down
- Observers do not receive updates after being removed
- Multiple observers receive updates correctly

---

## 💡 Usage Example

```java
StockAgent agent = new StockAgent();

StockBrokerAgency agency1 = new StockBrokerAgency();
StockBrokerAgency agency2 = new StockBrokerAgency();

agent.addObserver(agency1);
agent.addObserver(agency2);

agent.stockMarketUp(150);
```

---

## 🧠 Example Explanation

- A `StockAgent` is created  
- Two agencies subscribe to it  
- The stock market increases  
- The agent notifies all observers  
- Each observer receives and processes the message  
