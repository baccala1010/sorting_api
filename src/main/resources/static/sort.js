const numbersInput = document.getElementById('numbers');
const algorithmSelect = document.getElementById('algorithm');
const sortButton = document.getElementById('sort-button');
const sortedNumbersPre = document.getElementById('sorted-numbers');
const executionTimeSpan = document.getElementById('execution-time');

sortButton.addEventListener('click', async () => {
    const numbersString = numbersInput.value.trim();
    if (!numbersString) {
        alert('Please enter some numbers to sort');
        return;
    }
    const algorithm = algorithmSelect.value;

    // Validate user input: Numbers and spaces (regular expression)
    const numberRegex = /^\d+(?:\s+\d+)*$/;
    if (!numberRegex.test(numbersString)) {
        alert("Invalid input: Please enter only numbers separated by spaces");
        return;
    }

    // Convert user input to an array of numbers (robust conversion)
    const numbers = numbersString.split(/\s+/).map(str => {
        const number = Number(str.trim()); // Trim leading/trailing whitespace
        if (isNaN(number)) {
            alert(`Invalid number: "${str}"`); // Provide specific error message
            return; // Skip invalid numbers
        }
        return number;
    });

    if (!numbers.length) {
        alert("No valid numbers found for sorting");
        return;
    }

    const sortRequest = {
        "algorithm" : algorithm,
        "numbers" : numbersString, // Pass the array of numbers here
    };

    try {
        const response = await fetch('/sort', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(sortRequest), // Stringify the object
        });

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`Error sorting numbers: ${errorText}`); // Include response text for debugging
        }

        const data = await response.json();
        sortedNumbersPre.textContent = data.sortedNumbers;
        executionTimeSpan.textContent = data.executionTime;
    } catch (error) {
        console.error("Error:", error); // Log entire error for debugging
        alert("Error occurred: " + error.message);
    }
});
