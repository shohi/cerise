# TODO
- [ ] golang version manager
  + download pre-built binaries
  + aware multiple GOPATH
  + option to use global $GOBIN

- [ ] correct pyenv version in shims, like
  + correct pyenv version in shims, like
  ```bash
  cd .pyevn/shims
  rg "1.2.17" --files-with-matches | xargs sed -i '' 's/1.2.17/1.2.20/g'
  ```
  
- [ ] add daily routine script
  + brew update
  + brew upgrade
  + brew cask upgrade

- [ ] fuzzy find file matches given pattern
  + support both dir and file
  
- [ ] download k8s logs
  + support pod filter
