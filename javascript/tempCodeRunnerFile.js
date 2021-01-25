
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