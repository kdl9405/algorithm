  class User {
    constructor(name) { this.name = name; }
    sayHi() { console.log(this.name); }

    static sayHello(){ console.log('hello');}
  }
  
  let ray = new User('ray');

  User.sayHello();