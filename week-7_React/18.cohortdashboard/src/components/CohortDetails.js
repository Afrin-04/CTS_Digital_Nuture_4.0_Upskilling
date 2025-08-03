function CohortDetails({ cohort }) {
  if (!cohort) return <p>No cohort selected</p>;

  return (
    <div>
      <h3>{cohort.cohortCode}</h3>
      <p>Name: {cohort.name}</p>
      <p>Status: {cohort.status}</p>
      <p>Start Date: {cohort.startDate}</p>
      <p>End Date: {cohort.endDate}</p>
    </div>
  );
}

export default CohortDetails;
