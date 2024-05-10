# Java Streams Examples

This repository contains examples and exercises demonstrating the use of Java Streams. Java Streams are a powerful feature introduced in Java 8 for functional-style operations on collections and sequences of elements.

## Features

- Stream does not store elements. It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.
- Stream is functional in nature. Operations performed on a stream does not modify it's source. For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
- Stream is lazy and evaluates code only when required.
- The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.

## Getting Started

To run the examples in this repository, make sure you have Java 8 or higher installed on your system. You can clone this repository and execute the examples using any Java IDE or by compiling and running from the command line.

```bash
https://github.com/mGunawardhana/Java-Streams-Hidden-Features.git
```

## Contributing

Contributions to this repository are welcome! Feel free to submit pull requests with additional examples, improvements, or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/mGunawardhana/Java-Streams-Hidden-Features/new/master) file for details.
