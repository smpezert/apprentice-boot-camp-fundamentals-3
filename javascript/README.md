This project uses `node` version 10, and `nvm` (node version manager) to manage the version of `node`.

1. Make sure `nvm` is installed by running `brew list nvm || brew install nvm`.
1. Make sure you have the correct version of `node` by running `nvm install`.
1. Make sure you have all the required packages by running `npm install` (note the subtle difference between `nvm` in the previous step and `npm` here).

Now you can run the tests (against the right version of node) using `nvm use && npm test`.