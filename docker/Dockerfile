FROM jangrewe/gitlab-ci-android

# Installing build tools
RUN apt-get update && \
  apt-get install -y \
  build-essential \
  ruby \
  ruby-dev

# Installing fastlane
RUN gem install fastlane -NV

# Installing bundle
RUN gem install bundle