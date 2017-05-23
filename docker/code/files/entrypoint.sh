#!/usr/bin/env bash

tmux -2 new-session -d -s paco

tmux rename-window -t paco:0 'development'
tmux select-window -t paco:0
tmux send-keys -t paco:0 'echo welcome:development' C-m

tmux new-window -t paco
tmux rename-window -t paco:1 'postgres'
tmux select-window -t paco:1
tmux send-keys -t paco 'echo welcome:aux' C-m

tmux select-window -t paco:0
tmux -2 attach-session -t paco
