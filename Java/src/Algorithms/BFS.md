# BFS
목적: 한 정점에서 시작해서 모든 정점을 방문
+ 시작 정점 큐에 넣고
+ while(큐)
+ 큐에서 하나 빼고 -> x
+ x와 연결되어 있는 y중에서 방문하지 않은 모든 y를 큐에 넣음

bfs -> 최단거리 
+ 모든 가중치가 1이면 최단거리 
+ 큐에 넣을때 방문했다고 표시