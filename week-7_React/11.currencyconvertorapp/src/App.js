import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(prev => prev + 1);
    sayHello();
    staticMessage();
  };

  const decrement = () => {
    setCount(prev => prev - 1);
  };

  const sayHello = () => {
    alert("Increment Member1!");
  };

  const staticMessage = () => {
    console.log("This is a static message after increment.");
  };

  const sayWelcome = (msg) => {
    alert(`Welcome Message: ${msg}`);
  };

  const handleClick = () => {
    alert("I was clicked");
  };

  return (
    <div>
      <h2>{count}</h2>
      <button onClick={increment}>Increment</button>
      <br />
      <button onClick={decrement}>Decrement</button>
      <br />
      <button onClick={() => sayWelcome("Welcome")}>Say welcome</button>
      <br />
      <button onClick={handleClick}>Click on me</button>

      <hr />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
