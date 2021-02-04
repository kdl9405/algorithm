class Circle {
    constructor(radius) {
      this.radius = radius; // 반지름
    }
  
    // 원의 지름
    getDiameter() {
      return 2 * this.radius;
    }
  
    // 원의 둘레
    getPerimeter() {
      return 2 * Math.PI * this.radius;
    }
  
    // 원의 넓이
    getArea() {
      return Math.PI * Math.pow(this.radius, 2);
    }
  }
  
  // 자식 클래스
  
  
  // 반지름이 2, 높이가 10인 원통
  const cylinder = new Cylinder(10);
  console.log(cylinder.getArea());


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
  console.log(foo.#p);