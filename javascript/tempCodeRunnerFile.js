
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