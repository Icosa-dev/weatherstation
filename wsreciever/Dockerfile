FROM alpine:3.18

RUN apk --no-cache add ca-certificates bash wget git make \
  meson ninja-build \
  avr-libc gcc-avr \
  avrdude

WORKDIR /workdir