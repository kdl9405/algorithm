

const ray = new Person('OH')  // ReferenceError


// 클래스 선언문
class Person {
  // constructor(생성자)
  constructor(name) {
    this._name = name;
  }
}




const Foo = '';

{
  // 호이스팅이 발생하지 않는다면 ''가 출력되어야 한다.
  console.log(Foo);
  // ReferenceError: Cannot access 'Foo' before initialization
  // class Foo {}
}


console.log(foo); // undefined
var foo;

console.log(bar); // Error: Uncaught ReferenceError: bar is not defined
let bar;




class Foo {
  x = 1;            // Field declaration
  #p = 0;           // Private field
  static y = 20;    // Static public field
  static #sp = 30;  // Static private field
  // 2019/5 : Chrome 미구현
  // static #sm() {    // Static private method
  //   console.log('static private method');
  // }

  bar() {
    this.#p = 10; // private 필드 참조
    // this.p = 10; // 새로운 public p 필드를 동적 추가한다.
    return this.#p;
  }
}

const foo = new Foo();
console.log(foo); // Foo&nbsp;{#p: 10, x: 1}

console.log(foo.x); // 1
// console.log(foo.#p); // SyntaxError: Undefined private field #p: must be declared in an enclosing class
console.log(Foo.y); // 20
// console.log(Foo.#sp); // SyntaxError: Undefined private field #sp: must be declared in an enclosing class
console.log(foo.bar()); // 10


// unnamed
let Rectangle = class {
  constructor(height, width) {
    this.height = height;
    this.width = width;
  }
};
console.log(Rectangle.name);
// 출력: "Rectangle"

// named
let Rectangle = class Rectangle2 {
  constructor(height, width) {
    this.height = height;
    this.width = width;
  }
};
console.log(Rectangle.prototype);
// 출력: "Rectangle2"


test();

function test() {
  console.log("test");
}



class User {
  constructor(name) { this.name = name; }
  sayHi() { console.log(this.name); }

  static sayHello() { console.log('hello'); }
}

let ray = new User('ray');

User.sayHello();