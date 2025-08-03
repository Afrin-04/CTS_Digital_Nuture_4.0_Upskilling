import React from 'react';
import './App.css';
import officeImage from './assests\\office.png';

function App() {
  const officeList = [
    {
      Name: 'DBS',
      Rent: 50000,
      Address: 'Chennai',
      img: officeImage,
    },
    {
      Name: 'Regus',
      Rent: 65000,
      Address: 'Bangalore',
      img: officeImage,
    },
    {
      Name: 'WeWork',
      Rent: 55000,
      Address: 'Hyderabad',
      img: officeImage,
    },
  ];
    return (
    <div className="App">
      <h1>Office Space, at Affordable Range</h1>
      {officeList.map((office, index) => {
        const rentColor = office.Rent <= 60000 ? 'textRed' : 'textGreen';
        return (
          <div key={index} className="office-card">
            <img src={office.img} alt="Office Space" width="25%" height="25%" />
            <h2>Name: {office.Name}</h2>
            <h3 className={rentColor}>Rent: Rs. {office.Rent}</h3>
            <h3>Address: {office.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;

