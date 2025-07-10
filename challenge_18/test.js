import http from 'k6/http';
import { check, sleep } from 'k6';

// K6 test configuration
// Simulate 500 virtual users (VUs) running the script concurrently
export let options = {
    vus: 500, // Number of concurrent users
    duration: '1m', // Test duration (adjust as needed)
};

// Main function executed by each VU
export default function () {
    // 1. GET request to the main URL
    let getRes = http.get('https://test-api.k6.io/');
    // Check that the response status is 200 (OK)
    check(getRes, {
        'GET / status is 200': (r) => r.status === 200,
    });

    // 2. POST request to /user/register to register a fake user
    const payload = JSON.stringify({
        username: `fakeuser_${__VU}_${__ITER}`,
        password: 'FakePassword123!',
        email: `fakeuser_${__VU}_${__ITER}@example.com`,
    });
    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };
    let postRes = http.post('https://test-api.k6.io/user/register', payload, params);
    // Check that the response status is 201 (Created) or 409 (Conflict if user already exists)
    check(postRes, {
        'POST /user/register status is 201 or 409': (r) => r.status === 201 || r.status === 409,
    });

    // Optional: sleep to simulate user think time
    sleep(1);
}

// Note: This script is for testing purposes only. No real credentials or sensitive data are used.
