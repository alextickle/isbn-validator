import React, {useState} from 'react';
import ValidatorService from '../service/ValidatorService';
import Input from './Input';

const Validator = () => {

    const numberOfInputs = 5;
    const initialState = [];
    for (let i = 0; i < numberOfInputs; i++){
        initialState.push({id: i, type: 10, number: '', valid: null});
    }

    const [numbers, setNumbers] = useState(initialState);

    const handleTypeChange = (e) => {
        const i = e.target.name;
        const type = parseInt(e.target.value);
        setNumbers(oldArray => {
            oldArray[i].type = type;
            return [...oldArray];
        });
    }

    const handleInputChange = (e) => {
        const i = e.target.name;
        const number = e.target.value;
        setNumbers(oldArray => {
            oldArray[i].number = number;
            return [...oldArray];
        });
    }

    const handleClick = () => {
        const copyOfNumbers = [...numbers];
        // set valid to null for empty isbn numbers
        copyOfNumbers.forEach(number => {number.valid = null})
        numbers.forEach(isbn => {
            // remove hyphens
            isbn.number = isbn.number.replace(/-/g, '');
        })

        // only send non-empty isbn numbers
        ValidatorService.validateIsbnNumbers(numbers.filter(isbn => isbn.number !== ''))
            .then(validatedNumbers => {
                validatedNumbers.forEach(validatedNumber => {
                    copyOfNumbers[validatedNumber.id] = validatedNumber;
                })
                setNumbers(copyOfNumbers);
            })
    }

    return (
            <div>
                <div className="title">Validate ISBN numbers</div>
                {numbers.map((number, i) => <Input key={i} index={i} isbn={number} handleTypeChange={handleTypeChange} handleInputChange={handleInputChange}/>)}
                <button onClick={handleClick}>Validate</button>
            </div>
        );
}

export default Validator;