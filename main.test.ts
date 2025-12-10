import { main, displayData } from './main';

describe('Main', () => {
    let consoleLogSpy: jest.SpyInstance;
    let logOutput: string[];

    beforeEach(() => {
        logOutput = [];
        consoleLogSpy = jest.spyOn(console, 'log').mockImplementation((message: string) => {
            logOutput.push(message);
        });
    });

    afterEach(() => {
        consoleLogSpy.mockRestore();
    });

    test('should print hello world', () => {
        console.log('hello world');
        expect(logOutput[0]).toBe('hello world');
    });

    test('main should read and display data correctly', () => {
        main();
        
        const expectedOutput = [
            'email : thisemail@fake.com',
            'name : Joe Shmoe',
            'phone : 555-555-5555',
            'address : 1234 Fake St',
            'city : Faketown',
            'state : CA',
            'zip : 90210',
            'country : USA',
            'dob : 01/01/1900',
            'age : 95'
        ];

        expect(logOutput).toEqual(expectedOutput);
    });
});