# Observer Pattern Implementation in Java

A comprehensive implementation of the Observer design pattern in Java, demonstrating how to create a financial monitoring system where different services (Google, UOL) can subscribe to receive notifications when financial instruments (Títulos) are updated.

## 🎯 What is the Observer Pattern?

The Observer pattern is a behavioral design pattern that defines a one-to-many dependency between objects. When one object (the subject) changes state, all of its dependents (observers) are notified and updated automatically.

### Key Benefits:
- **Loose Coupling**: Subjects and observers are loosely coupled
- **Dynamic Relationships**: Observers can be added or removed at runtime
- **Broadcast Communication**: One subject can notify multiple observers
- **Open/Closed Principle**: Easy to add new observer types without modifying existing code

## 📁 Project Structure

```
observer-pattern/
├── Subject.java              # Subject interface defining subscription methods
├── Listener.java             # Observer interface defining update method
├── Titulo.java               # Concrete subject (financial instrument)
├── Google.java               # Concrete observer implementation
├── Uol.java                  # Concrete observer implementation
├── ExemploMonitoramento.java # Main class demonstrating the pattern
└── README.md                 # This file
```

## 🏗️ Architecture Overview

### Interfaces

#### Subject Interface
```java
public interface Subject {
    public void notifyListener(Listener l);
    public void subscribeListener(Listener l);
    public void unsubscribeListener(Listener l);
}
```

#### Listener Interface (Observer)
```java
public interface Listener {
    public void update(Titulo titulo);
}
```

### Concrete Implementations

#### Titulo (Concrete Subject)
Represents a financial instrument with the following properties:
- `codigo` - Instrument code
- `valorCompra` - Purchase price
- `valorVenda` - Sale price  
- `tipo` - Instrument type (Stock, Bond, Option, etc.)
- `dataVencimento` - Expiration date
- `dataLancamento` - Launch date

**Key Features:**
- Maintains a list of subscribers (observers)
- Automatically notifies all subscribers when any property changes
- Implements all Subject interface methods

#### Google & UOL (Concrete Observers)
Two different notification services that implement the Listener interface:
- **Google**: Receives and displays notifications from subscribed financial instruments
- **UOL**: Another news service that can monitor financial instruments

## 🚀 How to Run

### Prerequisites
- Java 8 or higher
- Any Java IDE or command line

### Compilation and Execution

1. **Compile all Java files:**
```bash
javac *.java
```

2. **Run the example:**
```bash
java ExemploMonitoramento
```

### Expected Output
```
Updating titulo1 valorCompra...
Google notified: Titulo{codigo='T1', valorCompra=110.0, valorVenda=105.0, tipo='Stock', dataVencimento=java.text.SimpleDateFormat@..., dataLancamento=java.text.SimpleDateFormat@...}

Updating titulo2 tipo...
Uol notified: Titulo{codigo='T2', valorCompra=200.0, valorVenda=205.0, tipo='Modified Bond', dataVencimento=java.text.SimpleDateFormat@..., dataLancamento=java.text.SimpleDateFormat@...}

Updating titulo3 codigo...
Google notified: Titulo{codigo='T3-Updated', valorCompra=300.0, valorVenda=305.0, tipo='Option', dataVencimento=java.text.SimpleDateFormat@..., dataLancamento=java.text.SimpleDateFormat@...}
Uol notified: Titulo{codigo='T3-Updated', valorCompra=300.0, valorVenda=305.0, tipo='Option', dataVencimento=java.text.SimpleDateFormat@..., dataLancamento=java.text.SimpleDateFormat@...}
```

## 📋 Example Usage

The `ExemploMonitoramento` class demonstrates three scenarios:

1. **Single Observer**: `titulo1` notifies only Google
2. **Single Observer**: `titulo2` notifies only UOL  
3. **Multiple Observers**: `titulo3` notifies both Google and UOL

```java
// Create financial instruments
Titulo titulo1 = new Titulo("T1", 100.0, 105.0, "Stock", sdf, sdf);

// Create observers
Listener google = new Google();
Listener uol = new Uol();

// Subscribe observers
titulo1.subscribeListener(google);

// Any property change triggers notifications
titulo1.setValorCompra(110.0); // Google gets notified
```

## 🔧 Extending the Implementation

### Adding New Observer Types
To add a new observer (e.g., Bloomberg):

```java
class Bloomberg implements Listener {
    @Override
    public void update(Titulo titulo) {
        System.out.println("Bloomberg received update: " + titulo.getCodigo());
    }
}
```

### Adding New Subject Types
To create new types of financial instruments, extend or create new classes that implement the `Subject` interface.

## 🎓 Learning Objectives

This implementation helps understand:

1. **Interface Segregation**: Clean separation between Subject and Observer responsibilities
2. **Polymorphism**: Different observer implementations can be treated uniformly
3. **Event-Driven Programming**: Objects react to state changes automatically
4. **Subscription Management**: Dynamic addition/removal of observers
5. **Notification Patterns**: Broadcast communication in software systems

## 📚 Related Patterns

- **Model-View-Controller (MVC)**: Observer pattern is fundamental to MVC architecture
- **Mediator Pattern**: Both deal with communication between objects
- **Command Pattern**: Can be combined with Observer for undo/redo functionality

## 🤝 Contributing

Feel free to fork this repository and submit pull requests for improvements:
- Add more observer implementations
- Implement filtering mechanisms
- Add error handling
- Improve the toString() method formatting
- Add unit tests

## 📄 License

This project is for educational purposes as part of Software Engineering studies at UFBA.

---

*This implementation was created as part of Software Engineering coursework, demonstrating the practical application of the Observer design pattern in Java.*
