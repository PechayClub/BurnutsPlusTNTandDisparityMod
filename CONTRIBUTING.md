## Conributing

- Your pull request should pass all checks. (Security, Build, and Azure DevOps)
- Make sure your pull request dosent contain patented or trademarked material.
- Make pull request are for the versions only supported in [SECURITY.md](https://github.com/Team-Burnuts/BurnutsPlusTNTandDisparityMod/blob/master/SECURITY.md.).
- Our code should be edit using MCreator not by using GitHub manually or a notepad to edit the file because your changes will get overwritten.
- Do not make a pull request that modifies anything it the .github folder and only collaborators can modify this folder.

If your pull request won't follow these guidelines will be closed without warning and labeled declined.

## CLA

Before we can use your code via Pull Request, you need to sign the [(Burnuts CLA)](https://cla-assistant.io/Team-Burnuts/BurnutsPlusTNTandDisparityMod), which you can do online.
The CLA is necessary mainly because you own the copyright to your changes, even after your contribution 
becomes part of our codebase, so we need your permission to use and distribute your code. We also need to be sure 
of various other things—for instance that you'll tell us if you know that your code infringes on other people's patents. 
You don't have to sign the CLA until after you've submitted your code for review and we approved it, but you must do it before  we can put your code into our codebase.

## For Collaborators

If your using your access token in your forked version of this repository when editing our workflows use it like this:

> token: ${{ secret.PERSONAL_ACCESS_TOKEN }}

Not like this:

> token: 'xxx.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX'
