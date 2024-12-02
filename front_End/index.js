import { YourServiceClient } from './generated/your_service_grpc_web_pb';
import { YourRequest, YourResponse } from './generated/your_service_pb';

const output = document.getElementById('areaOutput');
const input = document.getElementById('rectangleIn');
const genButton = document.getElementById('generateButton');

const client = new YourServiceClient('http://your-grpc-web-server-address');

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
