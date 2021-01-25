

function Person(name, age) {
  this.name = name;
  this.age = age;

}

var a = new Person('AAA', 10);

//확장
Person.prototype.hello = function () {
    console.log('hello', this.name, this.age);
}

a.hello();

var b = new Person('BBB', 20);


b.hello();


//변경
Person.prototype = { gender: 'male' };




// //확장
// Person.prototype.hello = function () {
//   console.log('hello222', this.name, this.age, this.gender);
// }

var c = new Person('CCC', 30);


// c.hello();






// function Person(name) {

//   this.name = name;
  
//   }
  
//   const foo = new Person('Lee');

//   // 프로토타입 객체의 확장
//   Person.prototype.hello = function () {
//     console.log('test')
//   }
  
//   // 프로토타입 객체의 변경  
//   Person.prototype = { gender: 'male' };
  
  
//   const bar = new Person('Kim');
  
//   console.log(foo.name); // 'Lee'
  
//   console.log(bar.name); // 'Kim'
  
//   console.log(foo.gender); // undefined
  
//   console.log(bar.gender); // 'male'

//   foo.hello();
//   bar.hello();
  
//   console.log(foo.constructor); // ① Person(name)
  
//   console.log(bar.constructor); // ② Object()