interface Student {
  name: string;
  percentage: number;
}

function printProgress(student: Student): void {
  console.log(student.name + ' has completed ' + student.percentage + '% of the bootcamp.');
}

const student1: Student = {
  name: 'Alice',
  percentage: 80
};

printProgress(student1);

// This will give an error
// printProgress({ name: 'Bob' });

printProgress({ name: 'Bob', percentage: 60 });