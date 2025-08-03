import React from 'react';
import { render, screen } from '@testing-library/react';
import CohortDetails from '../components/CohortDetails';
import { CohortData } from '../components/Cohort';

describe('CohortDetails Component', () => {
  const cohort = CohortData[0];

  test('renders without crashing', () => {
    render(<CohortDetails />);
    expect(screen.getByText(/no cohort selected/i)).toBeInTheDocument();
  });

  test('displays cohort code in h3', () => {
    render(<CohortDetails cohort={cohort} />);
    expect(screen.getByRole('heading', { level: 3 })).toHaveTextContent(cohort.cohortCode);
  });

  test('displays correct cohort info', () => {
    render(<CohortDetails cohort={cohort} />);
    expect(screen.getByText(`Name: ${cohort.name}`)).toBeInTheDocument();
    expect(screen.getByText(`Status: ${cohort.status}`)).toBeInTheDocument();
    expect(screen.getByText(`Start Date: ${cohort.startDate}`)).toBeInTheDocument();
    expect(screen.getByText(`End Date: ${cohort.endDate}`)).toBeInTheDocument();
  });
});
