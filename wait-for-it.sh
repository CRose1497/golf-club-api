#!/usr/bin/env bash
set -e

host="$1"
shift
cmd="$@"

until nc -z "$host" 3306; do
  echo "⏳ Waiting for MySQL at $host:3306..."
  sleep 2
done

>&2 echo "✅ MySQL is up — executing command"
exec $cmd
