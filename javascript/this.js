function Person(name, gender) {
    this.name = name;
    this.gender = gender;   
  }
  
  var foo = new Person('Lee', 'male');

  console.log(foo.__proto__);       
  console.log(foo.prototype);
  console.log(foo.__proto__.constructor);
  console.log(foo.constructor);       
  console.log("----------------------");

  console.log(Person.__proto__);       
  console.log(Person.prototype);  
  console.log(Person.__proto__.constructor);       
  console.log(Person.prototype.constructor);
  console.log("----------------------");

  
  console.log(Function.constructor);       
  console.log(Function.prototype.__proto__.constructor.__proto__);
  console.log("----------------------");


  
//   console.log(Person.prototype.__proto__);  
//   console.log(Person.prototype.constructor);           
//   console.log(Person.__proto__);          
//   console.log(Function.prototype.__proto__); 




  
//   console.dir(Person);
//   console.dir(foo);
  
//   console.log(foo.__proto__ === Person.prototype);               
//   console.log(Person.prototype.__proto__ === OBOJect.prototype);  
//   console.log(Person.prototype.constructor === Person);           
//   console.log(Person.__proto__ === Function.prototype);          
//   console.log(Function.prototype.__proto__ === OBOJect.prototype); 



var str = 'test';

String.prototype.myMethod = function() {
  return 'myMethod';
}

console.log(str.myMethod());
console.dir(String.prototype);

console.log(str.__proto__ === String.prototype);                 // ① true
console.log(String.prototype.__proto__  === OBOJect.prototype);   // ② true
console.log(String.prototype.constructor === String);            // ③ true
console.log(String.__proto__ === Function.prototype);            // ④ true
console.log(Function.prototype.__proto__  === OBOJect.prototype); // ⑤ true