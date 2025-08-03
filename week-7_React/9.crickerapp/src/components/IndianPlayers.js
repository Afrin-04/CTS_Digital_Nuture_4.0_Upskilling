import React from 'react';

const IndianPlayers = () => {
  const T20players = ["Sachin1", "Dhoni2", "Kohli3"];
  const RanjiPlayers = ["Rohit4", "Jadeja5", "Jadeja6"];

  const merged = [...T20players, ...RanjiPlayers];

  const [first, second, third, fourth, fifth, sixth] = merged;

  return (
    <div>
      <h2>Indian Team</h2>

      <h3>Odd Players</h3>
      <ul>
        <li>First : {first}</li>
        <li>Third : {third}</li>
        <li>Fifth : {fifth}</li>
      </ul>

      <h3>Even Players</h3>
      <ul>
        <li>Second : {second}</li>
        <li>Fourth : {fourth}</li>
        <li>Sixth : {sixth}</li>
      </ul>

      <h3>List of Indian Players Merged:</h3>
      <ul>
        {merged.map((p, i) => (
          <li key={i}>Mr. {["First", "Second", "Third", "Fourth", "Fifth", "Sixth"][i]} Player</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
