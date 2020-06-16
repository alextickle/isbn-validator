const SERVICE = "http://localhost:8080/isbn";

const validateIsbnNumbers = (numbers) => {
    return fetch(SERVICE + '/validate', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify(numbers),
            }).then(response => response.json())
//    return Promise.resolve([
//        {number: '1323', type: 10, isValid: false},
//        {number: '1323', type: 10, isValid: false},
//        {number: '1323', type: 10, isValid: false},
//        {number: '1323', type: 10, isValid: false},
//        {number: '1323', type: 10, isValid: false}
//    ])
}

export default {validateIsbnNumbers};