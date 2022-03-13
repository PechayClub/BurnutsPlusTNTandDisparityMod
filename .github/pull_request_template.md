name: Add features via Pull Request
description: Add an idea for this project
labels: [enhancement]
body:
- type: markdown
  attributes:
    value: |
      ## Use this form if you wan't to add a feature to TNT and Disparity Mod.
      **Note: This Pull Request will be added to a specific milestone before being added to our mod.**
- type: textarea
  attributes:
    label: Feature
    description: What do feature will you add for TNT and Disparity mod?
  validations:
    required: true
- type: textarea
  attributes:
    label: Benefit
    description: Is your/our benefit for this feature you want to add?
  validations:
    required: true
