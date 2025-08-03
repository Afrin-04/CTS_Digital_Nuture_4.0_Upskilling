import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee, onViewDetails }) {
  const theme = useContext(ThemeContext);

  return (
    <div className="employee-card">
      <h3>{employee.name}</h3>
      <button
        className={theme === "dark" ? "btn-dark" : "btn-light"}
        onClick={() => onViewDetails(employee)}
      >
        View Details
      </button>
    </div>
  );
}

export default EmployeeCard;
