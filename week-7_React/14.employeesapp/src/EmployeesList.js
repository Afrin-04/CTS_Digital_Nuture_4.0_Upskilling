import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeesList({ employees, onViewDetails }) {
  const theme = useContext(ThemeContext);

  return (
    <div>
      {employees.map((emp, index) => (
        <div key={index} style={{ marginBottom: "10px" }}>
          <h3>{emp.name}</h3>
          <button
            onClick={() => onViewDetails(emp)}
            className={theme === "dark" ? "btn-dark" : "btn-light"}
          >
            View Details
          </button>
        </div>
      ))}
    </div>
  );
}

export default EmployeesList;
