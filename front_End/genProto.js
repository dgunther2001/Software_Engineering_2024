import { RiemannSumServiceClient } from './generated/dataPass_grpc_web_pb';
import { ClientRequest, ServerResponse } from './generated/dataPass_pb';

const output = document.getElementById('areaOutput');
const input = document.getElementById('rectangleIn');
const genButton = document.getElementById('generateButton');

const client = new RiemannSumServiceClient('http://localhost:50051');

genButton.addEventListener('click', () => {
    const request = new ClientRequest();
    request.setInputFile(input.value);
    request.setOutputFile('output.txt');
    request.setDelimiter(',');
    request.setErrCode(0);

    client.createRiemannSum(request, {}, (err, response) => {
        if (err) {
            console.error(err);
            output.innerHTML = 'Error: ' + err.message;
        } else {
            output.innerHTML = 'Write to File: ' + response.getWriteToFile();
            console.log('Write to File: ' + response.getWriteToFile());
        }
    });
});

const protobuf = require("protobufjs");

// Load the protobuf definition
protobuf.load("dataPass.proto", function(err, root) {
    if (err) {
        throw err;
    }

    // Obtain the message types
    const ClientRequest = root.lookupType("dataPass.clientRequest");
    const ServerResponse = root.lookupType("dataPass.serverResponse");

    // Example payload
    const payload = {
        inputFile: "input.txt",
        outputFile: "output.txt",
        delimiter: ",",
        errCode: 0
    };

    // Verify the payload if necessary (optional)
    const errMsg = ClientRequest.verify(payload);
    if (errMsg) {
        throw Error(errMsg);
    }

    // Create a new message
    const message = ClientRequest.create(payload); // or use .fromObject if conversion is necessary

    // Encode a message to an Uint8Array (browser) or Buffer (node)
    const buffer = ClientRequest.encode(message).finish();
    // ... do something with buffer

    // Decode an Uint8Array (browser) or Buffer (node) to a message
    const decodedMessage = ClientRequest.decode(buffer);
    // ... do something with decodedMessage

    // If the application uses length-delimited buffers, there is also encodeDelimited and decodeDelimited.

    // Maybe convert the message back to a plain object
    const object = ClientRequest.toObject(decodedMessage, {
        longs: String,
        enums: String,
        bytes: String,
        // see ConversionOptions
    });

    console.log(object);
});
