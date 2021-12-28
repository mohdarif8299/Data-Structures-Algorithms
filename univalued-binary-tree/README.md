<h2>965. Univalued Binary Tree</h2><h3>Easy</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">A binary tree is <strong style="user-select: auto;">uni-valued</strong> if every node in the tree has the same value.</p>

<p style="user-select: auto;">Given the <code style="user-select: auto;">root</code> of a binary tree, return <code style="user-select: auto;">true</code><em style="user-select: auto;"> if the given tree is <strong style="user-select: auto;">uni-valued</strong>, or </em><code style="user-select: auto;">false</code><em style="user-select: auto;"> otherwise.</em></p>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/28/unival_bst_1.png" style="width: 265px; height: 172px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> root = [1,1,1,1,1,null,1]
<strong style="user-select: auto;">Output:</strong> true
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/28/unival_bst_2.png" style="width: 198px; height: 169px; user-select: auto;">
<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> root = [2,2,2,5,2]
<strong style="user-select: auto;">Output:</strong> false
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;">The number of nodes in the tree is in the range <code style="user-select: auto;">[1, 100]</code>.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">0 &lt;= Node.val &lt; 100</code></li>
</ul>
</div>