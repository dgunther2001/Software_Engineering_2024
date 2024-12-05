
const output = document.getElementById('areaOutput');
const input = document.getElementById('rectangleIn');
const genButton = document.getElementById('generateButton');

const client = new YourServiceClient('http://localhost:50051');

genButton.addEventListener('click', () => {
    const request = new YourRequest();
    request.setYourField(input.value);

    client.yourMethod(request, {}, (err, response) => {
        if (err) {
            console.error(err);
            output.innerHTML = 'Error: ' + err.message;
        } else {
            output.innerHTML = response.getYourResponseField();
            console.log(response.getYourResponseField());
        }
    });
});
