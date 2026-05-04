# 🥇 Level 1 - Builder Pattern

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
