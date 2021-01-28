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