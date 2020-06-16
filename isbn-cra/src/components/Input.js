import React from 'react'

const Input = ({isbn, index, handleInputChange, handleTypeChange}) => {

    return (
            <div className="container">
                <select name={index} onChange={handleTypeChange}>
                    <option value="10">10 Digit ISBN</option>
                    <option value="13">13 Digit ISBN</option>
                </select>
                <input name={index} type='text' onChange={handleInputChange} value={isbn.number}/>
                <div className='results'>
                    {isbn.valid === false && <div className="warning">Invalid ISBN</div>}
                    {isbn.valid && <div className="valid">Valid ISBN</div>}
                </div>
            </div>
        );
}

export default Input;