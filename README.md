# Binary Tree API
This API has been created to implement the following two EndPoints related with Binary Trees:
+ Create a Binary Tree: http://localhost:8080/binary_trees ```POST```. Body Example:
```
{
	"treeSize": 10,
	"maxValue": 10
}
```
+ Given a binary tree and two nodes, return the lowest common ancestor: http://localhost:8080/binary_trees/1/lowestCommonAncestor?value1=8&value2=5 ```GET```

## How to run this App
This application has benn dockerize and is available in DockerHub. In order to run this app, you can execute the next command in any PC with docker installed and Internet connection available:
```docker run --name binary-tree-api -d -p 8080:8080 -t dasetova/binary-tree-api:latest```
